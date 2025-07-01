import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Member } from '../../../../model/Member';
import { MemberService } from '../../../../services/Member-service';
import { MembershipType } from '../../../../model/MembershipType';
import { MembershipTypeService } from '../../../../services/Membership-type-service';
import { ZymService } from '../../../../services/zym-service';
import { Payment } from '../../../../model/Payment';
import { PaymentService } from '../../../../services/Payment-service';
import { User } from '../../../../model/user';

declare global {
  interface Window {
    Razorpay: any;
  }
}

interface RazorpayOrderResponse {
  id: string;
  amount: number;
  currency: string;
}

type RazorpayOptions = {
  key: string ;
  amount: number;
  currency: string;
  name: string;
  description: string;
  order_id: string;
  handler: (response: any) => void;
  prefill?: {
    name?: string;
    contact?: string;
  },
  notes?: { [key: string]: string };
  theme?: {
    color: string;
  };
};

@Component({
  selector: 'app-membership-form',
  standalone: false,
  templateUrl: './membership-form.html',
  styleUrls: ['./membership-form.css']
})
export class MembershipForm implements OnInit {

  @ViewChild('membershipformForm') membershipformForm!: NgForm;
  membershipform: Member = new Member();
  membership: MembershipType = new MembershipType();
  isPaymentProcessing: boolean = false;
  paymentMessage: string = '';
  userId : number =  sessionStorage.getItem("LogedinUser") as unknown as number;
  
  private razorpayKeyId: string = 'rzp_test_8mJ5HT9XEaSIhX'; 
  private razorpaySecretKey: string = 'OfELxKadbGMhF78CNM5Nvyno';
  private amount: number = this.membership.memberShipFee ;

 

  constructor(
    private memberService: MemberService,
    private membershipTypeService: MembershipTypeService,
    private zymService: ZymService,
    private paymentService: PaymentService
  ) { }

  ngOnInit(): void {
    this.getMembershipById();
    this.loadRazorpayScript();
    this.setInitialDates();
  }

  setInitialDates(): void {
  const today = new Date();
  this.membershipform.joiningDate = today.toISOString().split('T')[0];

  if (this.membership.membershipPeriod) {
    const period = this.membership.membershipPeriod.toLowerCase();
    let endDate = new Date(today);

    if (period.includes('month')) {
      const months = parseInt(period.split(' ')[0], 10);
      endDate.setMonth(endDate.getMonth() + months);
    } else if (period.includes('year')) {
      const years = parseInt(period.split(' ')[0], 10);
      endDate.setFullYear(endDate.getFullYear() + years);
    } else if (period.includes('day')) {
      const days = parseInt(period.split(' ')[0], 10);
      endDate.setDate(endDate.getDate() + days);
    }

    this.membershipform.endOfMembershipDate = endDate.toISOString().split('T')[0];
  } else {
    // Default to 30 days
    const endDate = new Date(today.setDate(today.getDate() + 30));
    this.membershipform.endOfMembershipDate = endDate.toISOString().split('T')[0];
  }
}

  getMembershipById(): void {
    const membershipId  = sessionStorage.getItem('userSelectedmembershipId');
    //alert(membershipId);
    if (!membershipId) {
      this.paymentMessage = 'Error: No membership selected.';
      return;
    }

    const MembershiptypeId = parseInt(membershipId,10);
    alert(MembershiptypeId);
    if (isNaN(MembershiptypeId)) {
      alert("invalid");
      this.paymentMessage = 'Error: Invalid membership ID.';
      return;
    }

    this.membershipTypeService.getMembershipTypeById(MembershiptypeId).subscribe(
      (response: any) => {
        console.log('Fetched membership:', response);
        this.membership = response;
        this.setInitialDates();
      },
      (error: any) => {
        console.error('Error fetching membership:', error);
        this.paymentMessage = 'Failed to load membership.';
      }
    );
  }

  private loadRazorpayScript(): void {
  const script = document.createElement('script');
  script.src = 'https://checkout.razorpay.com/v1/checkout.js';
  script.onload = () => {
    console.log('Razorpay SDK loaded.');
  };
  script.onerror = (error) => {
    console.error('Failed to load Razorpay:', error);
    this.paymentMessage = 'Could not load payment gateway.';
  };
  document.head.appendChild(script);
}

  async onPayNow(): Promise<void> {
    if (!this.membershipformForm.valid) {
      this.paymentMessage = 'Please complete the form.';
      return;
    }

    if (!this.membership.memberShipFee) {
      this.paymentMessage = 'Membership fee missing.';
      return;
    }

    this.isPaymentProcessing = true;
    this.paymentMessage = 'Initiating payment...';

    const paymentToSend: Payment = {
      paymentId: null,
      razorpayOrderId: '',
      razorpayPaymentId: '',
      amount: this.membership.memberShipFee * 100,
      date: new Date().toISOString().split('T')[0],
      time: new Date().toTimeString().split(' ')[0],
      
      user: new User()
    };

    try {
      const orderResponse = await this.paymentService.processPayment(paymentToSend, this.userId).toPromise() as RazorpayOrderResponse;
      console.log(this.userId)
      if (!orderResponse || !orderResponse.id) {
        throw new Error('Failed to create Razorpay order.');
      }

      const options: RazorpayOptions = {
        key: this.razorpayKeyId,
        amount: orderResponse.amount,
        currency: orderResponse.currency,
        name: 'FIT DECK',
        description: `Membership Payment for ${this.membership.memberShipname}`,
        order_id: orderResponse.id,
        handler: (response: any) => {
          console.log('Payment successful:', response);
          this.handleRazorpaySuccess(response);
        },
        theme: {
          color: '#3399CC'
        }
      };

      if (typeof window.Razorpay !== 'undefined') {
        const rzp = new window.Razorpay(options);
        rzp.open();
      } else {
        throw new Error('Razorpay SDK not loaded.');
      }

    } catch (error: any) {
      console.error('Payment failed:', error);
      this.paymentMessage = `Payment error: ${error.message || 'Unknown error'}`;
      this.isPaymentProcessing = false;
    }

  }
  private async handleRazorpaySuccess(response: any){
    this.paymentMessage = 'Payment successful! Verifying...';

    try {
      await this.paymentService.verifyPayment(response).toPromise();
      this.paymentMessage = 'Verified. Saving member info...';

      this.memberService.addMember(this.membershipform).subscribe(
        (memberResponse) => {
          console.log('Member added:', memberResponse);
          this.paymentMessage = 'Member registered and payment confirmed!';
          alert('Success: Member added and payment completed.');
        },
        (error) => {
          console.error('Failed to add member:', error);
          this.paymentMessage = 'Payment success, but member registration failed.';
          alert('Warning: Payment succeeded, but registration failed.');
        }
      );

    } catch (error: any) {
      console.error('Verification or saving failed:', error);
      this.paymentMessage = 'Payment verified, but an error occurred.';
      alert('Payment verified, but an error occurred while finalizing registration.');
    } finally {
      this.isPaymentProcessing = false;
    }
  }
}

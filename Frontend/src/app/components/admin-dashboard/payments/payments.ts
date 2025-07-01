// src/app/components/admin-dashboard/payments/payments.ts
import { Component, OnInit } from '@angular/core';
import { Payment } from '../../../model/Payment';
import { PaymentService } from '../../../services/Payment-service';
import { Member } from '../../../model/Member';
import { MemberService } from '../../../services/Member-service';

@Component({
  selector: 'app-payments',
  standalone: false,
  templateUrl: './payments.html',
  styleUrl: './payments.css'
})
export class Payments implements OnInit {

  Payment = new Payment();

  payments: Payment[] = [];
  members: Member[] = [];

  isShowing: boolean = true;
  isAdding: boolean = false;
  isEditing: boolean = false;
  selectedPaymentID: number = 0;

  constructor(
    private paymentService: PaymentService,
    private memberService: MemberService
  ) {}

  ngOnInit(): void {
    this.getallpayments();
    this.getallmembers();
  }

  getallpayments(): void {
    this.paymentService.getAllPayments().subscribe(
      (response: any) => {
        this.payments = response;
        console.log("All Payments:", this.payments);
      },
      (error: any) => {
        console.error("Error fetching payments:", error);
      }
    );
  }

  getallmembers(): void {
    this.memberService.getAllMembers().subscribe(
      (response: any) => {
        this.members = response;
        console.log("All Members for dropdown:", this.members);
      },
      (error: any) => {
        console.error("Error fetching members for dropdown:", error);
      }
    );
  }

  recordNewPayment(): void {
    this.isShowing = false;
    this.isAdding = true;
    this.isEditing = false;
    this.selectedPaymentID = 0;
    this.Payment = new Payment();
    this.Payment.date = new Date().toISOString().split('T')[0];
    this.Payment.time = new Date().toTimeString().split(' ')[0].substring(0, 5);
  }

  editPayment(paymentId: number): void {
    this.selectedPaymentID = paymentId;
    this.isShowing = false;
    this.isEditing = true;

    this.paymentService.getPaymentById(paymentId).subscribe(
      (response: any) => {
        this.Payment = response;

        if (this.Payment.date) {
          this.Payment.date = new Date(this.Payment.date).toISOString().split('T')[0];
        }
      },
      (error: any) => {
        console.error(`Error fetching payment with ID ${paymentId} for edit:`, error);
        this.cancelForm();
      }
    );
  }

  savePayment(): void {
    // Detach unsaved member if necessary

    if (this.isAdding) {
      this.paymentService.processPayment(this.Payment, this.Payment.user.userId).subscribe(
        (response: any) => {
          console.log("Payment recorded successfully:", response);
          this.getallpayments();
          this.cancelForm();
        },
        (error: any) => {
          console.error("Error recording payment:", error);
        }
      );
    } else if (this.isEditing) {
      this.paymentService.updatePayment(this.selectedPaymentID, this.Payment).subscribe(
        (response: any) => {
          console.log("Payment updated successfully:", response);
          this.getallpayments();
          this.cancelForm();
        },
        (error: any) => {
          console.error("Error updating payment:", error);
        }
      );
    }
  }

  deletePayment(paymentId: number): void {
    if (confirm("Are you sure you want to delete this payment record? This action cannot be undone.")) {
      this.paymentService.deletePayment(paymentId).subscribe(
        () => {
          console.log(`Payment with ID ${paymentId} deleted successfully.`);
          this.getallpayments();
        },
        (error: any) => {
          console.error(`Error deleting payment with ID ${paymentId}:`, error);
        }
      );
    }
  }

  cancelForm(): void {
    this.isAdding = false;
    this.isEditing = false;
    this.isShowing = true;
    this.selectedPaymentID = 0;
    this.Payment = new Payment();
  }
}

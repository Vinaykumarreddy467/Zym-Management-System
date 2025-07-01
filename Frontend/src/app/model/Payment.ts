import { User } from "./user";

export class Payment {
  paymentId: number |null ;
  amount: number;
  time: string;
  date: string;
  razorpayOrderId : string;
  razorpayPaymentId : string;
  user: User;
  
  constructor() {
    this.paymentId = null as any;
    this.amount = 0.0;
    this.time = '';
    this.date = '';
    this.razorpayOrderId = '';
    this.razorpayPaymentId = '';
    this.user = undefined as any;
   
  }
}
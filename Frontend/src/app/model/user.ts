import { Instructor } from "./Instructor";
import { Member } from "./Member";
import { MembershipType } from "./MembershipType";
import { Payment } from "./Payment";
import { PromotionalMaterial } from "./PromotionalMaterial";

export class User {
  userId: number;
  username: string;
  password: string;
  completeName: string;
  email : string;
  role : string;
  contact: string;
  address: string;
  membershipType : MembershipType;
  member : Member;
  instructor : Instructor;
  payment : Payment;
  promotionalMaterial : PromotionalMaterial;
 

  constructor() {
    this.userId = null as any;
    this.username = '';
    this.password = '';
    this.completeName = '';
    this.email = '';
    this.role = '';
    this.contact = '';
    this.address = '';
    this.membershipType = undefined as any;
    this.member = undefined as any;
    this.instructor = undefined as any;
    this.payment = undefined as any;
    this.promotionalMaterial =undefined as any;

  }
}
import { MembershipType } from "./MembershipType";
import { User } from "./user";
import { Zym } from "./Zym"; // Assuming you will have a Zym model in Angular

export class Member {
  memberId: number;
  zymname: string; 
  govtidNumber: string; 
  joiningDate: string;
  endOfMembershipDate: string;
  address: string;
  membershipId: string;
  user: User;
  membershipType: MembershipType;
  zym: Zym; // New field for Zym relationship

  constructor() {
    this.memberId = 0;
    this.zymname = '';
    this.govtidNumber = '';
    this.joiningDate = '';
    this.endOfMembershipDate = '';
    this.address = '';
    this.membershipId = '';
    this.user = new User();
    this.membershipType = new MembershipType();
    this.zym = new Zym(); // Initialize Zym
  }
}
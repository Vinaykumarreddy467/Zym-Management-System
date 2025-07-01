// MembershipType.ts
import { Zym } from "./Zym";
import { Member } from "./Member"; // Added import

export class MembershipType {
  typeId: number;
  memberShipname: string | undefined;
  memberShipFee: number;
  membershipPeriod: string;
  members: Member[]; 
  zym : Zym;
  

  constructor() {
    this.typeId = null as any;
    this.memberShipname = '';
    this.memberShipFee = 0.0;
    this.membershipPeriod = '';
    this.members = [];
    this.zym = undefined as any;
    
  }
}
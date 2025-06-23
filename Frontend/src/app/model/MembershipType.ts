import { User } from "./user";

export class MembershipType {
  typeId: number;
  name: string;
  memberShipFee: number;
  membershipPeriod: string;
  membershipAmount: number;
  user: User;

  constructor() {
    this.typeId = 0;
    this.name = '';
    this.memberShipFee = 0.0;
    this.membershipPeriod = '';
    this.membershipAmount = 0.0;
    this.user = new User(); // Initialize with a new User object
  }
}

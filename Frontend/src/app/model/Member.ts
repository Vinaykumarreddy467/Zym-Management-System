// Member.ts
import { MembershipType } from "./MembershipType";
import { User } from "./user";
import { WorkoutPlan } from "./WorkoutPlan";
import { Zym } from "./Zym";

export class Member {
  memberId: number | null ;
  GovtIdNumber: number;
  joiningDate: string;
  endOfMembershipDate: string;

  user: User;
  membershipType: MembershipType;
  zym: Zym;
  workoutPlans : WorkoutPlan[];

  constructor() {
    this.memberId = null as any;
    this.GovtIdNumber = null as any;
    this.joiningDate = '';
    this.endOfMembershipDate = '';

    this.user = undefined as any;
    this.membershipType = undefined as any;
    this.zym = undefined as any;
    this.workoutPlans = [];
  }
}
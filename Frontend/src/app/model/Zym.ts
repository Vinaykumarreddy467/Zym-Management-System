import { WorkoutPlan } from "./WorkoutPlan";
import { Instructor } from "./Instructor";
import { Member } from "./Member";
import { MembershipType } from "./MembershipType"; 

export class Zym {
  zymId: number;
  zymName: string;
  zymAddress: string;
  
  workoutPlans: WorkoutPlan[];
  instructors: Instructor[];
  members: Member[];
  membershipTypes: MembershipType[]; 

  constructor() {
    this.zymId = null as any;
    this.zymName = '';
    this.zymAddress = '';
    this.workoutPlans = [];
    this.instructors = [];
    this.members = [];
    this.membershipTypes = []; 
  }
}
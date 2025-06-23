import { WorkoutPlan } from "./WorkoutPlan";
import { Instructor } from "./Instructor";
import { Member } from "./Member";

export class Zym {
  zymId: number;
  zymName: string;
  zymAddress: string;
  workoutPlans: WorkoutPlan[];
  instructors: Instructor[];
  members: Member[];

  constructor() {
    this.zymId = 0;
    this.zymName = '';
    this.zymAddress = '';
    this.workoutPlans = [];
    this.instructors = [];
    this.members = [];
  }
}
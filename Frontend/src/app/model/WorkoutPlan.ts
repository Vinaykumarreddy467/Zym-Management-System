import { Instructor } from "./Instructor";
import { Member } from "./Member";

export class WorkoutPlan {
  planId: number;
  workOutname: string;
  workoutDate: string;
  workoutTime: string;
  member: Member;
  instructor: Instructor;

  constructor() {
    this.planId = 0;
    this.workOutname = '';
    this.workoutDate = '';
    this.workoutTime = '';
    this.member = new Member(); 
    this.instructor = new Instructor(); 
  }
}
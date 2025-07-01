// WorkoutPlan.ts
import { Instructor } from "./Instructor";
import { Member } from "./Member";
import { Zym } from "./Zym";
import { Workout } from "./Workout";

export class WorkoutPlan {
  planId: number ; 
  workOutname: string;
  workoutDate: string;
  workoutTime: string;
  member: Member | null; 
  instructor: Instructor | null; 
  zym: Zym | null; 
  workouts: Workout[];

  constructor() {
    this.planId = null as any;
    this.workOutname = '';
    this.workoutDate = '';
    this.workoutTime = '';
    this.member = undefined as any; 
    this.instructor = undefined as any; 
    this.zym = undefined as any; 
    this.workouts = [];
  }
}
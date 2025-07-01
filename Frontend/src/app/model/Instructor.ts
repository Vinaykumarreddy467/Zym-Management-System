// Instructor.ts
import { User } from "./user";
import { Zym } from "./Zym";
import { WorkoutPlan } from "./WorkoutPlan"; 
export class Instructor {
  instructorId: number ;
  name: string;
  email: string;
  contact: string;
  address: string;
  user: User;
  zym: Zym;
  workoutPlans : WorkoutPlan[]; 
  constructor() {
    this.instructorId = null as any;
    this.name = '';
    this.email = '';
    this.contact = '';
    this.address = '';
    this.user = new User();
    this.zym = new Zym();
    this.workoutPlans = [];
  }
}
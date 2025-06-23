import { User } from "./user";

export class Instructor {
  instructorId: number;
  name: string;
  email: string;
  contact: string;
  address: string;
  user: User;

  constructor() {
    this.instructorId = 0;
    this.name = '';
    this.email = '';
    this.contact = '';
    this.address = '';
    this.user = new User();
  }
}
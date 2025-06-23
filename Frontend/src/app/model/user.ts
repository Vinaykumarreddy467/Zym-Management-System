export class User {
  userId: number;
  username: string;
  password: string;
  completeName: string;
  email : string;
  role : string;
  contact: string;
  address: string;
  register: any;

  constructor() {
    this.userId = 0;
    this.username = '';
    this.password = '';
    this.completeName = '';
    this.email = '';
    this.role = '';
    this.contact = '';
    this.address = '';
  }
}

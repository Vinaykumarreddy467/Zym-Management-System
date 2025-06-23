import { User } from "./user";

export class PromotionalMaterial {
  promotionId: number;
  name: string;
  fileUpload: string;
  user: User;

  constructor() {
    this.promotionId = 0;
    this.name = '';
    this.fileUpload = '';
    this.user = new User(); 
  }
}
// PromotionalMaterial.ts
import { User } from "./user";

export class PromotionalMaterial {
  promotionId: number ;
  review: string; 
  fileUpload: string;
  user: User;

  constructor() {
    this.promotionId = null as any;
    this.review = ''; 
    this.fileUpload = '';
    this.user = undefined as any;
  }
}
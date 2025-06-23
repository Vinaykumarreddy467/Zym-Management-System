import { Component, OnInit } from '@angular/core';

import { PromotionalMaterial as PromoMaterialModel } from '../../../model/PromotionalMaterial';
import { Router } from '@angular/router';
import { PromotionalMaterialService } from '../../../services/Promotional-material-service';

@Component({
  selector: 'app-promotional-materialcomp',
  standalone: false,
  templateUrl: './promotional-materialcomp.html',
  styleUrl: './promotional-materialcomp.css'
})
export class PromotionalMaterialcomp implements OnInit {

  isShowing: boolean = true;
  isAdding: boolean = false;
  isEditing: boolean = false;
  selectedPromotionID: number = 0;

  PromoMaterialModel = new PromoMaterialModel();

  promotionalMaterialsList: any[] = [];

  constructor(
    private router: Router,
    private promotionalMaterialService: PromotionalMaterialService
   ) { }

  ngOnInit(): void {
    this.getAllPromotionalMaterials();
  }

  getAllPromotionalMaterials(): void {
    this.promotionalMaterialService.getAllPromotionalMaterials().subscribe(
      (response: any) => {
        this.promotionalMaterialsList = response;
        console.log("All Promotional Materials:", this.promotionalMaterialsList);
      },
      (error: any) => {
        console.error("Error fetching promotional materials:", error);
        this.promotionalMaterialsList = [];
      }
    );
  }

  addNewPromotion(): void {
    this.isShowing = false;
    this.isAdding = true;
    this.isEditing = false;
    this.selectedPromotionID = 0;
    this.PromoMaterialModel = new PromoMaterialModel();
  }

  editPromotion(promotionId: number): void {
    this.selectedPromotionID = promotionId;
    this.isShowing = false;
    this.isAdding = false;
    this.isEditing = true;

    this.promotionalMaterialService.getPromotionalMaterialById(promotionId).subscribe(
      (response: any) => {
        this.PromoMaterialModel = response;
      },
      (error: any) => {
        console.error(`Error fetching promotional material with ID ${promotionId} for edit:`, error);
        this.cancelForm();
      }
    );
  }

  savePromotion(): void {
    if (this.isAdding) {
      this.promotionalMaterialService.addPromotionalMaterial(this.PromoMaterialModel).subscribe(
        (response: any) => {
          console.log("Promotional Material added successfully:", response);
          this.getAllPromotionalMaterials();
          this.cancelForm();
        },
        (error: any) => {
          console.error("Error adding promotional material:", error);
        }
      );
    } else if (this.isEditing) {
      this.promotionalMaterialService.updatePromotionalMaterialById(this.selectedPromotionID, this.PromoMaterialModel).subscribe(
        (response: any) => {
          console.log("Promotional Material updated successfully:", response);
          this.getAllPromotionalMaterials();
          this.cancelForm();
        },
        (error: any) => {
          console.error("Error updating promotional material:", error);
        }
      );
    }
  }

  deletePromotion(promotionId: number): void {
    if (confirm("Are you sure you want to delete this promotional material? This action cannot be undone.")) {
      this.promotionalMaterialService.deletePromotionalMaterialById(promotionId).subscribe(
        () => {
          console.log(`Promotional Material with ID ${promotionId} deleted successfully.`);
          this.getAllPromotionalMaterials();
        },
        (error: any) => {
          console.error(`Error deleting promotional material with ID ${promotionId}:`, error);
        }
      );
    }
  }

  cancelForm(): void {
    this.isAdding = false;
    this.isEditing = false;
    this.isShowing = true;
    this.selectedPromotionID = 0;
    this.PromoMaterialModel = new PromoMaterialModel();
  }
}
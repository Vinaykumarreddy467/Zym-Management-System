import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MembershipType } from '../../../model/MembershipType';
import { MembershipTypeService } from '../../../services/Membership-type-service';

@Component({
  selector: 'app-membership-types',
  standalone: false,
  templateUrl: './membership-types.html',
  styleUrl: './membership-types.css'
})
export class MembershipTypes implements OnInit {

  membershipTypeForm: MembershipType = new MembershipType();

  membershipTypes: MembershipType[] = [];

  isShowing: boolean = true;
  isAdding: boolean = false;
  isEditing: boolean = false;
  selectedMembershipTypeID: number = 0;

  constructor(private membershipTypeService: MembershipTypeService, private router: Router) { }

  ngOnInit(): void {
    this.getallmembershipTypes();
  }

  getallmembershipTypes(): void {
    this.membershipTypeService.getAllMembershipTypes().subscribe(
      (response: any) => {
        this.membershipTypes = response;
        console.log("All Membership Types:", this.membershipTypes);
      },
      (error: any) => {
        console.error("Error fetching membership types:", error);
      }
    );
  }

  addNewMembershipType(): void {
    this.isShowing = false;
    this.isAdding = true;
    this.isEditing = false;
    this.selectedMembershipTypeID = 0;
    this.membershipTypeForm = new MembershipType();
  }

  editMembershipType(typeId: number): void {
    this.selectedMembershipTypeID = typeId;
    this.isShowing = false;
    this.isAdding = false;
    this.isEditing = true;

    this.membershipTypeService.getMembershipTypeById(typeId).subscribe(
      (response: any) => {
        this.membershipTypeForm = response;
      },
      (error: any) => {
        console.error(`Error fetching membership type with ID ${typeId} for edit:`, error);
        this.cancelForm();
      }
    );
  }

  saveMembershipType(): void {
    if (this.isAdding) {
      this.membershipTypeService.addMembershipType(this.membershipTypeForm).subscribe(
        (response: any) => {
          console.log("Membership Type added successfully:", response);
          this.getallmembershipTypes();
          this.cancelForm();
        },
        (error: any) => {
          console.error("Error adding membership type:", error);
        }
      );
    } else if (this.isEditing) {
      this.membershipTypeService.updateMembershipType(this.selectedMembershipTypeID, this.membershipTypeForm).subscribe(
        (response: any) => {
          console.log("Membership Type updated successfully:", response);
          this.getallmembershipTypes();
          this.cancelForm();
        },
        (error: any) => {
          console.error("Error updating membership type:", error);
        }
      );
    }
  }

  deleteMembershipType(typeId: number): void {
    if (confirm("Are you sure you want to delete this membership type? This action cannot be undone.")) {
      this.membershipTypeService.deleteMembershipType(typeId).subscribe(
        () => {
          console.log(`Membership Type with ID ${typeId} deleted successfully.`);
          this.getallmembershipTypes();
        },
        (error: any) => {
          console.error(`Error deleting membership type with ID ${typeId}:`, error);
        }
      );
    }
  }

  cancelForm(): void {
    this.isAdding = false;
    this.isEditing = false;
    this.isShowing = true;
    this.selectedMembershipTypeID = 0;
    this.membershipTypeForm = new MembershipType();
  }
}
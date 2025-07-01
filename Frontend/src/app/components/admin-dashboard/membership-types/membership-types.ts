import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MembershipType } from '../../../model/MembershipType';
import { MembershipTypeService } from '../../../services/Membership-type-service';
import { ZymService } from '../../../services/zym-service';
import { Zym } from '../../../model/Zym';

@Component({
  selector: 'app-membership-types',
  standalone: false,
  templateUrl: './membership-types.html',
  styleUrls: ['./membership-types.css'] 
})
export class MembershipTypes implements OnInit {

  membershipTypeForm: MembershipType = new MembershipType();

  membershipTypes: MembershipType[] = [];
  zyms: Zym[] = []; 
  isShowingList: boolean = true; 
  isAdding: boolean = false;  
  isEditing: boolean = false;

  selectedMembershipTypeID: number = 0; 
  constructor(
    private membershipTypeService: MembershipTypeService,
    private router: Router,
    private zymService: ZymService
  ) { }

  ngOnInit(): void {
    this.getallmembershipTypes();
    this.isShowingList = true;
    this.isAdding = false;
    this.isEditing = false;
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

  // UPDATED: Logic for showing the "Add New Membership Type" form
  addNewMembershipType(): void {
    // Hide the list and any active edit form
    this.isShowingList = false;
    this.isEditing = false;
    // Show the add form
    this.isAdding = true;

    // Reset the form for a new entry
    this.membershipTypeForm = new MembershipType();
    // Initialize the zym object within the form if it's null/undefined
    if (!this.membershipTypeForm.zym) {
      this.membershipTypeForm.zym = new Zym();
    }

    // Fetch all Zyms to populate the ZYM Name dropdown in the add form
    this.zymService.getAllZyms().subscribe(
      (response: any) => {
        this.zyms = response;
        console.log('Fetched Zyms for adding:', this.zyms);
      },
      (error: any) => {
        console.error("Error fetching Zyms:", error);
      }
    );
  }

  // UPDATED: Logic for showing the "Edit Membership Type" form
  editMembershipType(typeId: number): void {
    this.selectedMembershipTypeID = typeId;// Hide the list and any active add form
    this.isShowingList = false;
    this.isAdding = false;// Show the edit form
    this.isEditing = true;

    // Fetch the specific membership type data to populate the edit form
    this.membershipTypeService.getMembershipTypeById(typeId).subscribe(
      (response: any) => {
        this.membershipTypeForm = response;
        // Ensure the zym object exists to avoid errors with nested properties in the form
        if (!this.membershipTypeForm.zym) {
          this.membershipTypeForm.zym = new Zym();
        }
        // Fetch all Zyms to populate the ZYM Name dropdown in the edit form
        this.zymService.getAllZyms().subscribe(
          (zymResponse: any) => {
            this.zyms = zymResponse;
            console.log('Fetched Zyms for edit:', this.zyms);
          },
          (zymError: any) => {
            console.error("Error fetching Zyms during edit:", zymError);
          }
        );
      },
      (error: any) => {
        console.error(`Error fetching membership type with ID ${typeId} for edit:`, error);
        this.cancelForm(); // Go back to list view on error
      }
    );
  }

  // UPDATED: Logic for saving a new or edited membership type
  saveMembershipType(): void {
    if (this.isAdding) {
      // Logic for adding a new membership type

      this.membershipTypeService.addMembershipType(this.membershipTypeForm).subscribe(
        (response: any) => {
          console.log(this.membershipTypeForm);
          console.log("Membership Type added successfully:", response);
          this.getallmembershipTypes(); // Refresh the list
          this.cancelForm(); // Return to list view
        },
        (error: any) => {
          console.error("Error adding membership type:", error);
          // Keep form open on error or provide specific user feedback
        }
      );
    } else if (this.isEditing) {
      // Logic for updating an existing membership type
      this.membershipTypeService.updateMembershipType(this.selectedMembershipTypeID, this.membershipTypeForm).subscribe(
        (response: any) => {
          console.log("Membership Type updated successfully:", response);
          this.getallmembershipTypes(); // Refresh the list
          this.cancelForm(); // Return to list view
        },
        (error: any) => {
          console.error("Error updating membership type:", error);
          // Keep form open on error or provide specific user feedback
        }
      );
    }
  }

  deleteMembershipType(typeId: number): void {
    if (confirm("Are you sure you want to delete this membership type? This action cannot be undone.")) {
      this.membershipTypeService.deleteMembershipType(typeId).subscribe(
        () => {
          console.log(`Membership Type with ID ${typeId} deleted successfully.`);
          this.getallmembershipTypes(); // Refresh the list after deletion
        },
        (error: any) => {
          console.error(`Error deleting membership type with ID ${typeId}:`, error);
        }
      );
    }
  }

  // UPDATED: Logic for canceling form operation and returning to list view
  cancelForm(): void {
    // Hide both add and edit forms
    this.isAdding = false;
    this.isEditing = false;
    // Show the main membership types list
    this.isShowingList = true;
    // Reset selected ID and clear form data
    this.selectedMembershipTypeID = 0;
    this.membershipTypeForm = new MembershipType();
  }
}
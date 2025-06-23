import { Component, OnInit } from '@angular/core';
import { Member } from '../../../model/Member'; // Ensure this path is correct
import { MemberService } from '../../../services/Member-service'; // Ensure this path is correct
import { Router } from '@angular/router';

@Component({
  selector: 'app-members',
  standalone: false,
  templateUrl: './members.html',
  styleUrl: './members.css'
})
export class Members implements OnInit {

  zyms : any;
  membershipTypes: any;
  members: any;
  isShowing: boolean = true; 
  isEditing: boolean = false; 
  selectedMemberID: number = 0; 
  selectedMember: Member = new Member();

  constructor(private memberService: MemberService, private router: Router) { }

  ngOnInit(): void {
    this.getAllMembers();
  }

  getAllMembers(): void {
    this.memberService.getAllMembers().subscribe(
      (response: any) => {
        this.members = response;
        console.log("All members:", this.members);
      },
      (error) => {
        console.error("Error fetching members:", error);
        // You might want to display a user-friendly error message here
      }
    );
  }

  deleteMember(memberId: number): void {
    if (confirm("Are you sure you want to delete this member? This action cannot be undone.")) {
      this.memberService.deleteMemberById(memberId).subscribe(
        () => {
          console.log(`Member with ID ${memberId} deleted successfully.`);
          this.getAllMembers(); // Refresh the list after deletion
        },
        (error) => {
          console.error(`Error deleting member with ID ${memberId}:`, error);
          // Handle error, e.g., show a notification
        }
      );
    }
  }

  // Method to initiate the edit process
  editMember(memberId: number): void {
    this.selectedMemberID = memberId;
    this.isShowing = false; // Hide the table
    this.isEditing = true; // Show the edit form

    this.memberService.getMemberById(memberId).subscribe(
      (response: any) => {
        this.selectedMember = response;
        console.log(`Fetched member with ID ${memberId} for edit:`, response);
      },
      (error) => {
        console.error(`Error fetching member with ID ${memberId} for edit:`, error);
        // If there's an error fetching, revert to showing the list
        this.cancelEdit();
      }
    );
  }

  // Method to save the edited member
  saveMember(): void {
    // Call your service to update the member
    this.memberService.updateMemberById(this.selectedMemberID, this.selectedMember).subscribe(
      (response: any) => {
        console.log("Member updated successfully:", response);
        this.getAllMembers(); // Refresh the list after successful update
        this.cancelEdit(); // Hide the edit form and reset
      },
      (error) => {
        console.error("Error updating member:", error);
        // Keep the form open with an error message, or revert based on UX needs
        this.isEditing = true;
        this.isShowing = false;
      }
    );
  }

  // Method to cancel the edit operation
  cancelEdit(): void {
    this.isEditing = false; // Hide the edit form
    this.isShowing = true; // Show the table
    this.selectedMemberID = 0; // Reset selected ID
    this.selectedMember = new Member(); // Clear the selected member data
  }

  addNewMember(): void {
    console.log("Add New Member button clicked.");
    // This is where you would navigate to a new member creation form/page
    // this.router.navigate(['/members/add']);
  }
}
import { Component, OnInit } from '@angular/core';
import { Instructor } from '../../../model/Instructor';
import { InstructorService } from '../../../services/Instructor-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-instructors',
  standalone: false,
  templateUrl: './instructors.html',
  styleUrls: ['./instructors.css']
})
export class Instructors implements OnInit {

  instructors: any;

  isShowing: boolean = true;

  isEditing: boolean = false;

  selectedInstructorID: number = 0;

  selectedInstructor: any;

  instructor = new Instructor();

  constructor(private instructorService: InstructorService, private router: Router) {}

  ngOnInit(): void {
    this.getAllInstructors();
  }

  getAllInstructors() {
    this.instructorService.getAllInstructors().subscribe(
      (response: any) => {
        this.instructors = response;
        console.log("all instructors", this.instructors);
      },
      (error) => {
        console.log("Error fetching instructors:", error);
      }
    );
  }

  deleteInstructor(instructorId: number) {
    if (confirm("Are you sure you want to delete this instructor?")) {
      this.instructorService.deleteInstructor(instructorId).subscribe(
        (response: any) => {
          console.log("Instructor deleted successfully:", response);
          this.getAllInstructors();
        },
        (error) => {
          console.log("Error deleting instructor:", error);
        }
      );
    }
  }

  editInstructor(instructorId: number) {
    this.selectedInstructorID = instructorId;
    this.isShowing = false;
    this.isEditing = true;

    this.instructorService.getInstructorById(instructorId).subscribe(
      (response: any) => {
        this.selectedInstructor = response;
      },
      (error) => {
        console.log("Error fetching instructor for edit:", error);
      }
    );
  }

  saveInstructor(selectedInstructorID: number, selectedInstructor: any) {
    this.isEditing = false;
    this.isShowing = true;

    this.instructorService.updateInstructor(this.selectedInstructorID, this.selectedInstructor).subscribe(
      (response: any) => {
        console.log("Instructor updated successfully:", response);
        this.getAllInstructors();
        this.selectedInstructorID = 0;
        this.selectedInstructor = null;
      },
      (error) => {
        console.log("Error updating instructor:", error);
        this.isEditing = true;
        this.isShowing = false;
      }
    );
  }

  cancelEdit() {
    this.isEditing = false;
    this.isShowing = true;
    this.selectedInstructorID = 0;
    this.selectedInstructor = null;
  }
}
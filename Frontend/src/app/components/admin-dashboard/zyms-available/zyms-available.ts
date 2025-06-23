// zyms-available.component.ts
import { Component, OnInit } from '@angular/core';
import { Zym } from '../../../model/Zym';
import { ZymService } from '../../../services/zym-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-zyms-available',
  standalone: false,
  templateUrl: './zyms-available.html',
  styleUrl: './zyms-available.css'
})
export class ZymsAvailable implements OnInit {
  zym: Zym = new Zym(); 
  zyms: Zym[] = []; 

  isAdding: boolean = false; // to show add Zym form
  isUpdating: boolean = false; // to Update Zym form
  isListShowing: boolean = true; // to show Zyms list  table

  constructor(
    private zymService : ZymService,
    private router : Router
  ) { }

  ngOnInit(): void {
    this.getAllZyms();
  }

 
  getAllZyms(): void {
    this.zymService.getAllZyms().subscribe(
      (response: any) => {
        if (response) {
          this.zyms = response;
          console.log('Fetched Zyms:', this.zyms);
        } else {
          this.zyms = []; 
          console.log("No Zyms Found or empty response received.");
        }
      },
      (error) => {
        console.error('Error fetching Zyms:', error);
      }
    );
  }

  showAddForm(): void {
    this.zym = new Zym(); 
    this.isAdding = true;  //showing add form
    this.isUpdating = false;
    this.isListShowing = false; 
  }
  editZym(zymId: number): void {
  this.zymService.getZymById(zymId).subscribe(
    (response: any) => {
      console.log('Response', response);
      this.zym = response;
      this.isAdding = false;
      this.isUpdating = true;
      this.isListShowing = false;
    }
  );
  }
  

  updateZym(): void {
  if (!this.zym.zymId || !this.zym.zymName.trim() || !this.zym.zymAddress.trim()) {
    alert('Zym data (ID, Name, or Address) is incomplete for update.');
    return;
  }

  this.zymService.updateZym(this.zym.zymId, this.zym).subscribe(
    (response: any) => {
      console.log('Zym updated successfully:', response);
      this.getAllZyms();
      this.zym = new Zym();
      this.isAdding = false;
      this.isUpdating = false;
      this.isListShowing = true; // goes to list view
      window.location.reload();
    },
    (error) => {
      console.error('Error updating Zym:', error);
    }
  );
}

addNewZym(): void {
  if (!this.zym.zymName.trim() || !this.zym.zymAddress.trim()) {
    alert('Zym Name and Address are required.');
    return;
  }
  this.zymService.addZym(this.zym).subscribe(
    (response: any) => {
      console.log('Zym added successfully:', response);
      this.zym = new Zym();
      this.isAdding = false;
      this.isUpdating = false;
      this.isListShowing = true; // shows the zym's list
      this.getAllZyms();
      window.location.reload();
    },
    (error) => {
      console.error('Error adding Zym:', error);
    }
  );
}
  
  deleteZym(zymId: number): void {
    const confirmDelete = confirm('Are you sure you want to delete this Zym?');
    if (confirmDelete) {
        this.zymService.deleteZym(zymId).subscribe(
            (response: any) => {
                console.log('Zym Deleted Successfully:', response);
                this.getAllZyms();
                this.router.navigate(['/zymsavailable']);
                window.location.reload();
            },
            (error) => {
                console.error('Error deleting Zym:', error);
                
            }
        );
    }
  }

  
  cancelForm(): void {
    this.zym = new Zym(); 
    this.isAdding = false;
    this.isUpdating = false;
    this.isListShowing = true; 
  }

}
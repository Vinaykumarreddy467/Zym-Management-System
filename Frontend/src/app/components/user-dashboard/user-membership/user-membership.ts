import { Component, OnInit } from '@angular/core';
import { MembershipType } from '../../../model/MembershipType';
import { MembershipTypeService } from '../../../services/Membership-type-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-membership',
  standalone: false,
  templateUrl: './user-membership.html',
  styleUrl: './user-membership.css'
})
export class UserMembership implements OnInit {

  membershiptype = new MembershipType();
  membershiptypes : any;
  userId = sessionStorage.getItem("LogedinUser");
  membershipPlanExists :  boolean = true;

  constructor( 
    private membershipTypeService: MembershipTypeService,
    private router : Router
  ) { }
  ngOnInit(): void {
    this.membershipTypeByUserId();    
  }

  membershipTypeByUserId() {
      this.membershipTypeService.getMembershipTypeByUserId(Number(this.userId)).subscribe(
        (response: any) => {
          this.membershiptype = response;
        },
        (error: any) => {
          console.error('Error fetching membership type by user ID:', error);
          alert('you dont have any active plans at the moment please purchase a plan');
          this.membershipPlanExists = false;   
          this.getallmembershipTypes();
                
        }
      )
  }
  getallmembershipTypes(){
    this.membershipTypeService.getAllMembershipTypes().subscribe(
      (response : any) => {
        this.membershiptypes = response;
        console.log(response);
      }
    )
  }
}

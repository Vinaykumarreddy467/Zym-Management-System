import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MembershipTypeService } from '../../../../services/Membership-type-service';
import { MembershipType } from '../../../../model/MembershipType';

@Component({
  selector: 'app-usermembership-types',
  standalone: false,
  templateUrl: './usermembership-types.html',
  styleUrl: './usermembership-types.css'
})
export class UsermembershipTypes implements OnInit{

  membershipTypes : any = []
  membership = new MembershipType();
  constructor( 
          private router : Router,
          private membershipTypeService: MembershipTypeService
  ) { }

  ngOnInit(): void {
    this.getallmembershipTypes();
    
  }
  getallmembershipTypes(){
    this.membershipTypeService.getAllMembershipTypes().subscribe(
      (response : any) => {
        console.log(response);
        this.membershipTypes = response;
      }
    )
  }
  selectPlan(typeId: number){
    this.membership.typeId = typeId;
    sessionStorage.setItem('userSelectedmembershipId', this.membership.typeId.toString());
    this.router.navigate([`/usermembershipplan`]);
  }

}

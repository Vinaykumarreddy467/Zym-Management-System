import { Component, OnInit } from '@angular/core';
import { MembershipTypeService } from '../../../services/Membership-type-service';
import { Router } from '@angular/router';
import { MembershipType } from '../../../model/MembershipType';

@Component({
  selector: 'app-membershiptypes',
  standalone: false,
  templateUrl: './membershiptypes.html',
  styleUrl: './membershiptypes.css'
})
export class Membershiptypes  implements OnInit {

  membershiptype = new MembershipType();
  membershiptypes : any;
  constructor(
    private MembershipTypeService: MembershipTypeService,
    private router : Router
  ) { }

  ngOnInit(): void {
     this.getallmembershipTypes()

  } 
  getallmembershipTypes(){
    this.MembershipTypeService.getAllMembershipTypes().subscribe(
      (response : any) => {
        this.membershiptypes = response;
        console.log(response);
      }
    )
  }

}

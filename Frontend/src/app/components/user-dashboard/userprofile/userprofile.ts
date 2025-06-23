import { Component, OnInit } from '@angular/core';
import { Member } from '../../../model/Member';
import { MemberService } from '../../../services/Member-service';

@Component({
  selector: 'app-userprofile',
  standalone: false,
  templateUrl: './userprofile.html',
  styleUrl: './userprofile.css'
})
export class Userprofile implements OnInit{

  member =new Member();
  userId:any={};
  isEditing : boolean = false;
  constructor( private memberService : MemberService) { }

  ngOnInit(): void {
    this.userId=sessionStorage.getItem("LogedinUser");
    console.log(this.userId);
    this.getmemberByuserId();
  }
  getmemberByuserId() {
    console.log(this.userId);
    this.memberService.getmemberByuserId(this.userId).subscribe(
      (response: any) => {
        this.member = response;
        console.log("Member:", this.member);
      }      
    )
    
  }
  toggleEditMode() {
  }
  saveProfile() {
  }
}

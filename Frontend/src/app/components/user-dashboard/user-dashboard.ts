import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { User } from '../../model/user';

@Component({
  selector: 'app-user-dashboard',
  standalone: false,
  templateUrl: './user-dashboard.html',
  styleUrl: './user-dashboard.css'
})
export class UserDashboard implements OnInit {

  loginStatus : boolean = false;
  username : string = '';
  user = new User();
  constructor( private router : Router) { }

  ngOnInit(): void {
      if( sessionStorage.getItem("LogedinUser")!==null){
            this.loginStatus = true;
            this.username = sessionStorage.getItem("LogedinUsername") as string;
        }
  }

}


import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  standalone: false,
  templateUrl: './admin-dashboard.html',
  styleUrl: './admin-dashboard.css'
})
export class AdminDashboard  implements OnInit {

  loginStatus : boolean = false;

  constructor(private router : Router) { }
  ngOnInit(): void {
    if( sessionStorage.getItem("LogedinUser")!==null){
          this.loginStatus = true;
      }
  }
  logout(){
    sessionStorage.removeItem("LogedinUser");
    this.loginStatus = false;
    this.router.navigate(['/login']);
  }
}

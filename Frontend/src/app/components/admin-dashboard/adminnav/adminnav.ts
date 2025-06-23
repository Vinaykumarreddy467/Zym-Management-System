import { Component, OnInit } from '@angular/core';
import { User } from '../../../model/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminnav',
  standalone: false,
  templateUrl: './adminnav.html',
  styleUrl: './adminnav.css',
  
})
export class Adminnav implements OnInit {

  user = new User();

  constructor(private router : Router) { }

  ngOnInit(): void {
  }

  logout(){
    sessionStorage.removeItem("LogedinUser");
    this.router.navigate(['/login']);
  }


}

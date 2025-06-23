import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-usernav',
  standalone: false,
  templateUrl: './usernav.html',
  styleUrl: './usernav.css'
})
export class Usernav {


  constructor(private router : Router) { }
  logout() {
    sessionStorage.removeItem("LogedinUser");
    this.router.navigate(['/']);
    

  }
}

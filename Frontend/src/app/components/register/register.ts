import { Component } from '@angular/core';
import { User } from '../../model/user';
import { OnInit } from '@angular/core';
import { UserService } from '../../services/UserService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: false,
  templateUrl: './register.html',
  styleUrl: './register.css'
})
export class Register  implements OnInit {
  
  user =new User;
    constructor(private userService : UserService, private router : Router) { }

  ngOnInit(): void {
    
  }

  onSubmit() {
    this.userService.register(this.user).subscribe(() => {
      console.log(this.user);
      alert('Registration successful');
      this.router.navigate(['/login']);  
    });
  }
}
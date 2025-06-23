import { Component, OnInit } from '@angular/core';
import { User } from '../../../model/user';
import { UserService } from '../../../services/UserService';

@Component({
  selector: 'app-users',
  standalone: false,
  templateUrl: './users.html',
  styleUrl: './users.css'
})
export class Users  implements OnInit{
  user =new User();
  users: any;

  p : number = 1;
  count : number = 5;

  constructor(private userService : UserService) { }
  ngOnInit(): void {
    this.getAllUsers();
  }
  getAllUsers() {
    this.userService.getAllUsers(this.users).subscribe(
      (response : any) => {
        this.users = response;
      }
    )
    
  }
  editUser(userId: number) {
    console.log('Edit user with ID:', userId);
  }

  deleteUser(userId: number) {
    
  }
}

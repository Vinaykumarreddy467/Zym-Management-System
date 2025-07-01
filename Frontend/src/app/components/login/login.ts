import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user';
import { Router } from '@angular/router';
import { UserService } from '../../services/UserService';
import { InstructorService } from '../../services/Instructor-service';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.html',
  styleUrls: ['./login.css']  
})
export class Login implements OnInit {
  user: User = new User();
  loginStatus: boolean = false;
  constructor(private userService: UserService, private router: Router, private instructorService : InstructorService) {}

  ngOnInit(): void {}

  onSubmit() {
    this.userService.login(this.user).subscribe(
      (response : any) => {
        console.log(response)
        if(response==null){
          alert('Login Failed : Invalid Credentials /n Please Enter Valid Credentials /n /n If you are a new user please register first');          
        }        
         sessionStorage.setItem("LogedinUser",response.userId );
         sessionStorage.setItem("LogedinUsername",response.username );
         sessionStorage.setItem("LogedinRole",response.role );
         console.log(response);
        if (response!=null){
          if(response.role=='admin'){
              this.user=response;
              console.log(this.user +" "+response.role);
              this.router.navigate(['/admin']);
            }
            else if(response.role=='user'){
              this.user=response;
              console.log(this.user+" "+response.role);
              alert(this.user.userId);
              this.router.navigate(['/Userdashboard']);
            }
            else if(response.role=='instructor'){
              this.user=response; 
              console.log(this.user+" "+response.role);
              this.router.navigate(['/Instructor']);
            }
            else{
              this.router.navigate(['/login']);
              alert('Login Failed : Invalid Credentials /n Please Enter Valid Credentials');
            }
          }  
        }
      );
    }
  }
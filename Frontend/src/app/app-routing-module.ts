import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Register } from './components/register/register';
import { Login } from './components/login/login';
import { Welcome } from './components/welcome/welcome';
import { AdminDashboard } from './components/admin-dashboard/admin-dashboard';
import { UserDashboard } from './components/user-dashboard/user-dashboard';
import { Instructors } from './components/admin-dashboard/instructors/instructors';
import { Members } from './components/admin-dashboard/members/members';
import { Users } from './components/admin-dashboard/users/users';
import { Workouts } from './components/admin-dashboard/workouts/workouts';
import { WorkoutPlans } from './components/admin-dashboard/workout-plans/workout-plans';
import { MembershipTypes } from './components/admin-dashboard/membership-types/membership-types';
import { Payments } from './components/admin-dashboard/payments/payments';
import { PromotionalMaterialcomp } from './components/admin-dashboard/promotional-materialcomp/promotional-materialcomp';
import { WorkoutList } from './components/welcome/workout-list/workout-list';
import { Membershiptypes } from './components/welcome/membershiptypes/membershiptypes';
import { Userprofile } from './components/user-dashboard/userprofile/userprofile';
import { UserMembership } from './components/user-dashboard/user-membership/user-membership';
import { ZymsAvailable } from './components/admin-dashboard/zyms-available/zyms-available';
import { UsermembershipTypes } from './components/user-dashboard/user-membership/usermembership-types/usermembership-types';

const routes: Routes = [
  {path: "", component:Welcome},
  {path: "register", component:Register},
  {path: "login", component:Login},
  {path: "admin", component:AdminDashboard},
  {path: "Userdashboard", component: UserDashboard},
  {path: "allinstructors" , component : Instructors},
  {path: "allmembers" , component : Members},
  {path: "allusers" , component : Users},
  {path: "allworkouts", component : Workouts},
  {path: "allworkoutplans", component: WorkoutPlans},
  {path: "allmembershiptypes", component : MembershipTypes},
  {path: "allpayments", component : Payments},
  {path: "allpromotionalmaterials", component : PromotionalMaterialcomp},
  {path: "workoutlist", component: WorkoutList},
  {path: "allmembershiptypeswelcome" , component : Membershiptypes},
  {path: "userprofile" , component : Userprofile},
  {path: "mymembership" , component : UserMembership},
  {path: "allusermembershiptypes" , component : UsermembershipTypes},
  {path : "allzyms" , component: ZymsAvailable },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
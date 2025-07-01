import { NgModule, NO_ERRORS_SCHEMA, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import {  FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { Router, RouterModule } from '@angular/router';
import { Register } from './components/register/register';
import { Login } from './components/login/login';
import { Welcome } from './components/welcome/welcome';
import { AdminDashboard } from './components/admin-dashboard/admin-dashboard';
import { UserDashboard } from './components/user-dashboard/user-dashboard';
import { Adminnav } from './components/admin-dashboard/adminnav/adminnav';
import { InstructorDashboard } from './components/instructor-dashboard/instructor-dashboard';
import { Users } from './components/admin-dashboard/users/users';
import { Members } from './components/admin-dashboard/members/members';
import { Instructors } from './components/admin-dashboard/instructors/instructors';
import { WorkoutPlans } from './components/admin-dashboard/workout-plans/workout-plans';
import { MembershipTypes } from './components/admin-dashboard/membership-types/membership-types';
import { Payments } from './components/admin-dashboard/payments/payments';
import { CommonModule } from '@angular/common';
import { Workouts } from './components/admin-dashboard/workouts/workouts';
import { PromotionalMaterialcomp } from './components/admin-dashboard/promotional-materialcomp/promotional-materialcomp';
import { Slides } from './components/welcome/slides/slides';
import { NgxPaginationModule } from 'ngx-pagination';
import { Welcomenav } from './components/welcome/welcomenav/welcomenav';
import { WorkoutList } from './components/welcome/workout-list/workout-list';
import { Membershiptypes } from './components/welcome/membershiptypes/membershiptypes';
import { Usernav } from './components/user-dashboard/usernav/usernav';
import { Userprofile } from './components/user-dashboard/userprofile/userprofile';
import { UserMembership } from './components/user-dashboard/user-membership/user-membership';
import { ZymsAvailable } from './components/admin-dashboard/zyms-available/zyms-available';
import { UsermembershipTypes } from './components/user-dashboard/user-membership/usermembership-types/usermembership-types';
import { MembershipForm } from './components/user-dashboard/user-membership/membership-form/membership-form';




@NgModule({
  declarations: [
    App,
    Login,
    Register,
    Welcome,
    AdminDashboard,
    UserDashboard,
    Adminnav,
    InstructorDashboard,
   
    Users,
    Members,
    Instructors,
    WorkoutPlans,
    MembershipTypes,
    Payments,
    Workouts,
    PromotionalMaterialcomp,
    Slides,
    Welcomenav,
    WorkoutList,
    Membershiptypes,
    Usernav,
    Userprofile,
    UserMembership,
    ZymsAvailable,
    UsermembershipTypes,
    MembershipForm,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    CommonModule,
    NgxPaginationModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners()
  ],
  bootstrap: [App]
})
export class AppModule { }

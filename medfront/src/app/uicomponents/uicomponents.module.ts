import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
   
  ],
  imports: [
    CommonModule,
    MatSlideToggleModule,
    FormsModule,
    HttpClientModule
  ],
  exports:[
    MatSlideToggleModule,
    FormsModule,
    HttpClientModule
  ]
})
export class UicomponentsModule { }

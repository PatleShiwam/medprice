import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'medfront';
  searchQuery:string='';


  constructor(private http: HttpClient) { }

  medicineInfo: any;
  dismissOverlay() {
    // Set medicineInfo to a non-null value to hide the overlay and show the table
    this.medicineInfo = [];
  }


  search() {
    const url = `http://localhost:8080/info/${this.searchQuery}`;
   

    this.http.get(url)
      .subscribe((response) => {
        this.medicineInfo = response;
        
        console.log('Medicine Info:', this.medicineInfo);
      },
      (error) => {
        if (error.status === 404) {
          // Handle the 404 error by displaying a "Medicine not found" message
          this.medicineInfo = null; // Clear any previous data
        } else {
          // Handle other errors here
          console.error('Error:', error);
        }
      });
  }
  
    


}

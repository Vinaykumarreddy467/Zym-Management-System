  import { Injectable } from '@angular/core';
  import { environment } from './baseUrl';
  import { HttpClient } from '@angular/common/http';

  @Injectable({
    providedIn: 'root'
  })
  export class PromotionalMaterialService {
    private apiUrl = `${environment.apiBaseUrl}/api/promotional-materials`
    constructor(private http : HttpClient) { }

    addPromotionalMaterial(promotionalMaterial: any ){
      return this.http.post(this.apiUrl, promotionalMaterial);
    }
    getAllPromotionalMaterials(){
      return this.http.get(`${this.apiUrl}/getall`);
    }
    getPromotionalMaterialById(promotionalMaterialId: number){
      return this.http.get(`${this.apiUrl}/getbyid/${promotionalMaterialId}`);
    }
    updatePromotionalMaterialById(promotionalMaterialId: number, promotionalMaterial: any){
      return this.http.put(`${this.apiUrl}/updatebyid/${promotionalMaterialId}`, promotionalMaterial);
    }
    deletePromotionalMaterialById(promotionalMaterialId: number){
      return this.http.delete(`${this.apiUrl}/${promotionalMaterialId}`);
    }
  }

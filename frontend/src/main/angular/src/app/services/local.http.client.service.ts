import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable()
export class LocalHttpClientService{

  constructor(private httpClient: HttpClient) {

  }

  getAllMaterials(){
    return this.httpClient.get('http://localhost:8080/market-0.0.1/raw-materials');
  }
}

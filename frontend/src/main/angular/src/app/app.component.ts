import {Component, OnInit} from '@angular/core';
import {LocalHttpClientService} from "./services/local.http.client.service";
import {RawMaterialsModel} from "./models/raw.materials.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'angular';
  rawMaterialList : RawMaterialsModel [];

  constructor(private httpService: LocalHttpClientService) {
  }

  ngOnInit(): void {
    console.log("ngOnInit")
    this.httpService.getAllMaterials().subscribe(
      result => {
        console.log(JSON.stringify(result));
        this.rawMaterialList = JSON.parse(JSON.stringify(result));
      }
    )
  }


}

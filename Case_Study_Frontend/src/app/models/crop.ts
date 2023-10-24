export class Crop {
    constructor(){
        this.cropId = '';
        this.cropName = '';
        this.cropimage = '';
        this.cropqlty = 0;

        this.croplocation = '';
        this.cropcontact = '';
        this.cropqnty = 0;
        this.cropdesc = '';
        this.cropprice = 0;
        // this.farmerId = '';
        this.farmerEmail = '';
        this.farmerName='';

    }
    cropId?: string;
    cropName: string;
    cropimage: string;
    cropqlty: number;
    croplocation: string;
    cropcontact: string;
    cropqnty: number;
    cropdesc: string;
    cropprice: number;
    // farmerId: string;
    farmerName:string;
    farmerEmail: string;
}

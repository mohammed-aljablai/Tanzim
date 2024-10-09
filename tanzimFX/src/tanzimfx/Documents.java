/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tanzimfx;

/**
 *
 * @author Mohammed Al-jabalai
 */
public class Documents {



    private boolean photoForProofDocuments;

    private boolean personalPhoto;
    private boolean highSchoolCertificate;
    private boolean trueCopy;

    public Documents(boolean highSchoolCertificate, boolean personalPhoto, boolean photoForProofDocuments, boolean trueCopy) {
        this.highSchoolCertificate = highSchoolCertificate;
        this.personalPhoto = personalPhoto;
        this.photoForProofDocuments = photoForProofDocuments;
        this.trueCopy = trueCopy;
    }


    public boolean isHighSchoolCertificate() {
        return highSchoolCertificate;
    }

    public void setHighSchoolCertificate(boolean highSchoolCertificate) {
        this.highSchoolCertificate = highSchoolCertificate;
    }

    public boolean isPersonalPhoto() {
        return personalPhoto;
    }

    public void setPersonalPhoto(boolean personalPhoto) {
        this.personalPhoto = personalPhoto;
    }

    public boolean isPhotoForProofDocuments() {
        return photoForProofDocuments;
    }

    public void setPhotoForProofDocuments(boolean photoForProofDocuments) {
        this.photoForProofDocuments = photoForProofDocuments;
    }

    public boolean isTrueCopy() {
        return trueCopy;
    }

    public void setTrueCopy(boolean trueCopy) {
        this.trueCopy = trueCopy;
    }




}

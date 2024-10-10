/*
 - This project call tanzim.
 - tanzim: is a project where orgnize the stuednt and the doctor, in addtion
   the emplyee life> from sending msg update degree and more...
 - this project have been worked by:
   - Mohammed Abdullh Al-jablai
   - Gamal Aldeen Al-hakl
   - Youseef Al-asadi
   - abdAlmalik
*/
/* 
    - this class is (Documents) where it links in the students class
      to know if the stuents have this document or not
    - هذا الكلاس لمعرفة الطالب هل يملك هذه المستندات أم لا
      سيتم إدراجه في كلاس الطالب كعنصر اوبجكت
*/
package tanzimfx;


public class Documents {
    
    // properties
    private boolean photoForProofDocuments;
    private boolean personalPhoto;
    private boolean highSchoolCertificate;
    private boolean trueCopy;
    
    // Methods
    // counstructor method
    public Documents(boolean highSchoolCertificate, boolean personalPhoto, boolean photoForProofDocuments, boolean trueCopy) {
        this.highSchoolCertificate = highSchoolCertificate;
        this.personalPhoto = personalPhoto;
        this.photoForProofDocuments = photoForProofDocuments;
        this.trueCopy = trueCopy;
    }
    
    // Setter and getter Methods
    // photoForProofDocuments
    public boolean hasPhotoForProofDocuments() {
        return photoForProofDocuments;
    }
    public void setPhotoForProofDocuments(boolean photoForProofDocuments) {
        this.photoForProofDocuments = photoForProofDocuments;
    }
    // personalPhoto
    public boolean hasPersonalPhoto() {
        return personalPhoto;
    }
    public void setPersonalPhoto(boolean personalPhoto) {
        this.personalPhoto = personalPhoto;
    }
    // highSchoolCertificate
    public boolean hasHighSchoolCertificate() {
        return highSchoolCertificate;
    }
    public void setHighSchoolCertificate(boolean highSchoolCertificate) {
        this.highSchoolCertificate = highSchoolCertificate;
    }
    // trueCopy
    public boolean hasTrueCopy() {
        return trueCopy;
    }
    public void setTrueCopy(boolean trueCopy) {
        this.trueCopy = trueCopy;
    }

}

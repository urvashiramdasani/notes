package PrototypeDesignPattern;

public class ResumeDocument implements Document {
    private String content;
//    private Header header;
//    private Footer footer;
//    private List<Image> embeddedImages;

    @Override
    public Document clone() {
        ResumeDocument document = new ResumeDocument();
        document.content = this.content;
//        document.header = this.header.clone();
//        document.footer = this.footer.clone();
//        document.embeddedImages = deepCopyImages(embeddedImages);
        return document;
    }
}

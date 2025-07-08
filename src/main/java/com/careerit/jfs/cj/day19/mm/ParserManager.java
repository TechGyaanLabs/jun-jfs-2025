package com.careerit.jfs.cj.day19.mm;

public class ParserManager {

    public static void main(String[] args) {

        Parser parser = getParser(ParserType.ICICI);
        parser.parse();

    }

    private static Parser getParser(ParserType parserType) {
        switch (parserType) {
            case ICICI:
                return new IciciParser();
            case SBI:
                return new SBIParser();
            case YESBANK:
                return new YesBankParser();
            default:
                throw new IllegalArgumentException("Invalid parser type");
        }
    }
}

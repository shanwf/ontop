package it.unibz.inf.ontop.cli;

import org.junit.Ignore;
import org.junit.Test;

public class OntopMappingV1ToV3Test {

    @Test
    public void testOntopHelp (){
        String[] argv = {"help", "mapping", "v1-to-v3"};
        Ontop.main(argv);
    }

    @Test
    public void OntopOBDACleanup (){
        String[] argv = {"mapping", "v1-to-v3",
                "-m", "/Users/Sarah/Projects/ontop/client/cli/src/test/resources/bootstrapped-univ-benchQL.obda",
                "-o", "/Users/Sarah/Projects/ontop/client/cli/src/test/resources/output/bootstrapped-univ-benchQL.obda"
        };
        Ontop.main(argv);
    }

    @Ignore("Overwrite the file")
    @Test
    public void OntopOBDACleanupNoOutput (){
        String[] argv = {"mapping", "v1-to-v3",
                "-m", "client/cli/src/test/resources/bootstrapped-univ-benchQL.obda",
                "--overwrite"
        };
        Ontop.main(argv);
    }

    @Test
    public void OntopOBDACleanupProjection (){
        String[] argv = {"mapping", "v1-to-v3",
                "-m", "client/cli/src/test/resources/books/exampleBooks.obda",
//                "--overwrite",
                "-o", "client/cli/src/test/resources/output/exampleBooks-cleanup.obda",
                "--simplify-projection",

        };
        Ontop.main(argv);
    }


    @Test
    public void OntopR2rmlCleanupAllSetting (){
        String[] argv = {"mapping", "v1-to-v3",
                "-m", "client/cli/src/test/resources/npd-v2-ql-mysql-ontop1.17.ttl",
                "-o", "client/cli/src/test/resources/output/npd-v2-ql-mysql-ontop1.17.ttl"
        };
        Ontop.main(argv);
    }

    @Ignore("Overwrite the file")
    @Test
    public void OntopR2RMLCleanupNoOutput (){
        String[] argv = {"mapping", "v1-to-v3",
                "-m", "client/cli/src/test/resources/npd-v2-ql-mysql-ontop1.17.ttl",
                "--overwrite"
        };
        Ontop.main(argv);
    }

    @Test
    public void OntopR2rmlCleanupProjection (){
        String[] argv = {"mapping", "v1-to-v3",
                "-m", "client/cli/src/test/resources/books/exampleBooks.ttl",
                "-o", "client/cli/src/test/resources/output/exampleBooks.ttl",
                "--simplify-projection"
        };
        Ontop.main(argv);
    }

    @Ignore("Overwrite the file")
    @Test
    public void OntopR2rmlCleanupOverwrite (){
        String[] argv = {"mapping", "v1-to-v3",
                "-m", "client/cli/src/test/resources/books/exampleBooks.ttl",
                "--overwrite"
        };
        Ontop.main(argv);
    }


}

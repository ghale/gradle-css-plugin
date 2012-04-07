package com.eriwen.gradle.css

import org.gradle.api.Project

/**
 * Utility for executing JS with Rhino.
 *
 * @author Eric Wendelin
 * @date 2/20/12
 */
class RhinoExec {
    private static final String RHINO_MAIN_CLASS = 'org.mozilla.javascript.tools.shell.Main'
    Project project

    void execute(final Iterable<String> execargs, final File outputFile, final String workingDirIn = '.') {
        def options = {
            main = RHINO_MAIN_CLASS
            classpath = project.configurations.rhino
            args = execargs
            workingDir = workingDirIn
            standardOutput = new FileOutputStream(outputFile)
        }

        project.javaexec(options)
    }

    public RhinoExec(final Project projectIn) {
        project = projectIn
    }
}

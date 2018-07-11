package com.garudaone.nfo.job;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import java.io.File;

public class FileMover implements Tasklet, InitializingBean {
    private Resource directory;


    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        File srcdir = directory.getFile();

        File[] files = srcdir.listFiles();
        for(int i=0;i<files.length;i++)
        {
            files[i].renameTo(new File(files[i].getAbsolutePath()+"\\Archive\\"+files[i].getName()+".txt"));
        }
        return  RepeatStatus.FINISHED;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(directory,"directory must be set");
    }


    public Resource getDirectory() {
        return directory;
    }

    public void setDirectory(Resource directory) {
        this.directory = directory;
    }

}

package uk.gov.hmrc.jenkinsjobbuilders.domain.publisher

import javaposse.jobdsl.dsl.Job
import uk.gov.hmrc.jenkinsjobbuilders.domain.AbstractJobSpec
import uk.gov.hmrc.jenkinsjobbuilders.domain.builder.JobBuilder

import static uk.gov.hmrc.jenkinsjobbuilders.domain.publisher.HtmlReportsPublisher.htmlReportsPublisher

class HtmlReportsPublisherSpec extends AbstractJobSpec {

    void 'With keepAll'() {
        given:
        JobBuilder jobBuilder = new JobBuilder('test-job', 'test-job-description').
                withPublishers(htmlReportsPublisher(['target/fun-browser-test-reports/html-report': 'ScalaTest (fun-browser) Results'], true))

        when:
        Job job = jobBuilder.build(JOB_PARENT)

        then:
        with(job.node) {

            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.reportName.text() == 'ScalaTest (fun-browser) Results'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.reportDir.text() == 'target/fun-browser-test-reports/html-report'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.allowMissing.text() == 'true'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.keepAll.text() == 'true'
        }
    }

    void 'Without keepAll (default)'() {
        given:
        JobBuilder jobBuilder = new JobBuilder('test-job', 'test-job-description').
                withPublishers(htmlReportsPublisher(['target/fun-browser-test-reports/html-report': 'ScalaTest (fun-browser) Results']))

        when:
        Job job = jobBuilder.build(JOB_PARENT)

        then:
        with(job.node) {

            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.reportName.text() == 'ScalaTest (fun-browser) Results'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.reportDir.text() == 'target/fun-browser-test-reports/html-report'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.allowMissing.text() == 'true'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.keepAll.text() == 'false'
        }
    }

    void 'Without keepAll'() {
        given:
        JobBuilder jobBuilder = new JobBuilder('test-job', 'test-job-description').
                withPublishers(htmlReportsPublisher(['target/fun-browser-test-reports/html-report': 'ScalaTest (fun-browser) Results'], false))

        when:
        Job job = jobBuilder.build(JOB_PARENT)

        then:
        with(job.node) {

            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.reportName.text() == 'ScalaTest (fun-browser) Results'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.reportDir.text() == 'target/fun-browser-test-reports/html-report'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.allowMissing.text() == 'true'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.keepAll.text() == 'false'
        }
    }

    void 'With alwaysLinkToLastBuild'() {
        given:
        JobBuilder jobBuilder = new JobBuilder('test-job', 'test-job-description').
                withPublishers(htmlReportsPublisher(['target/fun-browser-test-reports/html-report': 'ScalaTest (fun-browser) Results'], false, true))

        when:
        Job job = jobBuilder.build(JOB_PARENT)

        then:
        with(job.node) {

            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.reportName.text() == 'ScalaTest (fun-browser) Results'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.reportDir.text() == 'target/fun-browser-test-reports/html-report'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.allowMissing.text() == 'true'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.alwaysLinkToLastBuild.text() == 'true'
        }
    }

    void 'Without alwaysLinkToLastBuild (default)'() {
        given:
        JobBuilder jobBuilder = new JobBuilder('test-job', 'test-job-description').
                withPublishers(htmlReportsPublisher(['target/fun-browser-test-reports/html-report': 'ScalaTest (fun-browser) Results']))

        when:
        Job job = jobBuilder.build(JOB_PARENT)

        then:
        with(job.node) {

            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.reportName.text() == 'ScalaTest (fun-browser) Results'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.reportDir.text() == 'target/fun-browser-test-reports/html-report'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.allowMissing.text() == 'true'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.alwaysLinkToLastBuild.text() == 'false'
        }
    }

    void 'Without alwaysLinkToLastBuild'() {
        given:
        JobBuilder jobBuilder = new JobBuilder('test-job', 'test-job-description').
                withPublishers(htmlReportsPublisher(['target/fun-browser-test-reports/html-report': 'ScalaTest (fun-browser) Results'], false, false))

        when:
        Job job = jobBuilder.build(JOB_PARENT)

        then:
        with(job.node) {

            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.reportName.text() == 'ScalaTest (fun-browser) Results'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.reportDir.text() == 'target/fun-browser-test-reports/html-report'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.allowMissing.text() == 'true'
            publishers.'htmlpublisher.HtmlPublisher'.reportTargets.'htmlpublisher.HtmlPublisherTarget'.alwaysLinkToLastBuild.text() == 'false'
        }
    }
}

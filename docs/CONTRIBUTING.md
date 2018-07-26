# Contributing to TEAMMATES

Thanks for taking your time to contribute to TEAMMATES!

We welcome contributions from anyone, in particular, students (see [here](https://teammatesv4.appspot.com/about.jsp) for the list of our contributors). One of the main objectives of TEAMMATES is to help students get experience in a OSS production environment. Here are some information that might be useful to would-be contributors.

* [Getting started](#getting-started)
  * [Know the product/project](#know-the-productproject)
  * [Code of Conduct](#code-of-conduct)
* [How can I contribute?](#how-can-i-contribute)
  * [Submitting an issue](#submitting-an-issue)
  * [Manual testing](#manual-testing)
  * [Submitting a pull request](#submitting-a-pull-request)
* [Contributor orientation guide](#contributor-orientation-guide)
  * [Knowledge required](#knowledge-required)
  * [Orientation task list](#orientation-task-list)
* [Other resources](#other-resources)

## Getting started

### Know the product/project

Understand what TEAMMATES is about, both as a product (users' point of view) and a project (developers' point of view).

* [Product intro page](https://teammatesv4.appspot.com) shown to potential users
* [Features overview](https://teammatesv4.appspot.com/features.jsp)
* [Project vision, challenges, and principles](overview.md)

### Code of Conduct

By participating in this project, you agree to uphold the [TEAMMATES Code of Conduct](../.github/CODE_OF_CONDUCT.md), which is adopted from [Contributor Covenant Code of Conduct](https://www.contributor-covenant.org/).

## How can I contribute?

### Submitting an issue

We use the [issue tracker](https://github.com/TEAMMATES/teammates/issues) to contain bug reports and feature/enhancement requests.
Before submitting a new issue, search the issue tracker to ensure that there is no similar open issue.

If you are certain that you are reporting a new issue, [open a new issue](https://github.com/TEAMMATES/teammates/issues/new) using the templates provided.

### Manual testing

We welcome anyone manually testing our product and reporting bugs or suggestions for enhancements in the issue tracker.

If you want to undertake such a role without actually contributing code, [get an instructor account from TEAMMATES](https://teammatesv4.appspot.com/request.jsp).
Remember to mention the purpose of your request under "Any other comments/queries". 

### Submitting a pull request

We accept patches/fixes in form of pull requests (PRs). Make sure that the pull request addresses an open issue in the issue tracker.
Remember to follow the [TEAMMATES Development Process](process.md).

By submitting a PR, you agree to allow the project team to license your work under the terms of the [GNU GPL v2 License](../LICENSE).

If this is your first time contributing to TEAMMATES, you may want to read up the contributor orientation guide lined out in the next section.

## Contributor orientation guide

Contributing to an OSS project requires you to figure out things on your own when you can, and seek help from the right resource (Google, StackOverflow, troubleshooting guides, issue tracker, etc.) when you cannot. To become a TEAMMATES contributor, you need to start honing those skills. To help you with that, we have created a sequence of tasks you can try to complete. Try to complete as many of them as you can, in the order they are listed.

Of course we are happy to guide you if you encounter any difficulties when doing these tasks; we have provided a [troubleshooting guide](troubleshooting-guide.md) for some commonly faced problems. Failing that, you may post a help request in our [issue tracker](https://github.com/TEAMMATES/teammates/issues).

> - The task descriptions are brief by intention. We want you to try to figure out how to do those things by yourself.
> - While the dev team members will be glad to answer your questions, you will not make a good impression if you ask questions which are already answered in the mentioned resources.

### Knowledge required

Although TEAMMATES uses many tools and technologies, you need not know all of them before you can contribute. The diagram below shows which technologies you need to learn to contribute in different roles.

![RolesAndTechnologies.png](images/RolesAndTechnologies.png)

Note that these roles are not fixed or formally assigned; it is simply for guidance only.

Roles:

* **Web page developer**: Works on static web pages, such as those used in the TEAMMATES product web site.
* **Front end developer**: Works on the front end of the app that is generated dynamically from the server side.
* **Test developer**: Works on automating system tests.
* **Back end developer**: Works on the back end logic of the app, including data storage.
* **DevOps developer**: Works on automations (CI, static analysis, scripting) and operations (logging, monitoring, troubleshooting).

### Orientation task list

#### Phase A: Set up locally

1. [Set up TEAMMATES development environment on your computer.](setting-up.md)<br>
   **Important: Follow instructions to the letter. Install the specified versions of the tool stack, not the latest versions.**
1. Get the tests to pass (more info in [_Development Guidelines_ document](development.md)).
   It is OK to proceed to the next phase if you have fewer than 5 failing test cases.

#### Phase B: Learn

In order to contribute effectively, you are advised to learn how to do the various development routines lined out in [the _Development Guidelines_ document](development.md).
Try your best to be familiar with at least building and testing the application in your local development environment.

#### Phase C: Start contributing

When you are ready for a real contribution, you are advised to start with an issue labelled [d.FirstTimers](https://github.com/TEAMMATES/teammates/issues?q=is:issue+is:open+label:d.FirstTimers) (but do not do more than one of those), then move on to other issues labelled [d.Contributors](https://github.com/TEAMMATES/teammates/issues?q=is:issue+is:open+label:d.Contributors).
Steps for fixing an issue are lined out in the [process document](process.md).

> In the event that you cannot find a `d.FirstTimers`-labelled issue, you can start with a `d.Contributors`-labelled issue.
> You can consult the `e.*` label, if it is present, to estimate the difficulty. Lower number generally means less amount of work required.

#### Important

Fixing an issue quickly is not the important thing. In fact, issues given to new contributors are the ones we already know how to fix.
We are more interested to see how you go about fixing the issue. We want to know whether you are systematic and detail-oriented.

Take your time to learn and follow the workflow to the letter. Do not skip any steps because you think that step is "not important". We are more impressed when you finish an issue in fewer attempts than when you finish it in a shorter time but take many attempts because you were not meticulous enough along the way.

## Other resources

* [Support request](../.github/SUPPORT.md)
* [Comprehensive directory of resources, including style guides](../docs/README.md)

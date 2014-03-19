---
layout: page
title: REFT
tagline: automated source code REFactoring Tool
---
{% include JB/setup %}

Status: Proof of concept development

# The Problem

Upgrading libraries is a difficult business. Library maintainers are
held back from making breaking changes because they suspect or 'know'
that the changes they would like to make will cause problems for the
teams they are trying to help.

Lets assume that a library exposes a public method:

{% highlight java %}
package org.awesome;

public class SomeAwesomeCapability {

	public static void someAwesomeMethod() {
		...
	}
}
{% endhighlight %}

And the consumer of that library

{% highlight java %}
import org.awesome;

public class Main {
	public void main(String[] args) {
		...
		SomeAwesomeCapability.someAwesomeMethod();
		...
	}
}
{% endhighlight %}

Over time the library maintainers discover that the method name does
not quite fit with the rest of the library or for some other reason
would like to update the method name.

The usual approach is to mark the current method as deprecated and add
a better named method. Some time later the deprecated method will be
removed. In the mean time consumers of the library will be encouraged
to update their use of the library to use the new method. During the
deprecation cycle there library has two methods that do very similar
work - not ideal. It become even more unattractive with other types of
change are required.

# REFT

The idea behind REFT allows the library maintainers to publish a
specification of changes with their library. This specification can
then be applied to the calling code.

REFT file

	migration 1.0.2 -> 1.0.3 {
		rename method invocation org.awesome.SomeAwesomeCapability.someAwesomeMethod() -> someMoreAwesomeMethod()
	}

The REFT file is read by REFT and applied to the calling code to bring
it up to date or to report on the changes that are required.

Once confidence in the update process is reaches and updates are fully
automated the changes can be integrated into a Continuous Delivery
pipeline. Changes would flow unencumbered through the system and
verified through automated tests in the consuming applicaiton.


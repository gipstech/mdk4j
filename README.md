# GiPStech MDK Java Wrapper

This repository provides a set of wrapper classes that enable Java applications to interact with the GiPStech MDK.

The GiPStech MDK is implemented in Kotlin and extensively relies on Kotlin coroutines for asynchronous operations. However, Kotlin suspend functions cannot be directly invoked from Java code due to language-level limitations.

To bridge this interoperability gap, the wrapper classes in this repository expose blocking versions of the MDK's coroutine-based APIs. This allows legacy or pure Java applications to seamlessly integrate the latest GiPStech MDK functionalities without requiring migration to Kotlin or coroutine support.

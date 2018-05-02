# 流的基本概念
> 1.1 什么是流

> 众所周知，集合操作非常麻烦，若要对集合进行筛选、投影，需要写大量的代码，而流是以声明的形式操作集合，它就像SQL语句，我们只需告诉流需要对集合进行什么操作，它就会自动进行操作，并将执行结果交给你，无需我们自己手写代码。因此，流的集合操作对我们来说是透明的，我们只需向流下达命令，它就会自动把我们想要的结果给我们。由于操作过程完全由Java处理，因此它可以根据当前硬件环境选择最优的方法处理，我们也无需编写复杂又容易出错的多线程代码了

> 1.2 流的特点

>> a）只能遍历一次 
   我们可以把流想象成一条流水线，流水线的源头是我们的数据源(一个集合)，数据源中的元素依次被输送到流水线上，我们可以在流水线上对元素进行各种操作。一旦元素走到了流水线的另一头，那么这些元素就被“消费掉了”，我们无法再对这个流进行操作。当然，我们可以从数据源那里再获得一个新的流重新遍历一遍
   
>> b）采用内部迭代方式 
若要对集合进行处理，则需我们手写处理代码，这就叫做外部迭代。而要对流进行处理，我们只需告诉流我们需要什么结果，处理过程由流自行完成，这就称为内部迭代。

> 1.3 流的操作类型

流的操作分为两种，分别为中间操作 和 终端操作。

> 中间操作：
>> 当数据源中的数据上了流水线后，这个过程对数据进行的所有操作都称为“中间操作”。 
中间操作仍然会返回一个流对象，因此多个中间操作可以串连起来形成一个流水线。

> 终端操作：
>> 当所有的中间操作完成后，若要将数据从流水线上拿下来，则需要执行终端操作。 
终端操作将返回一个执行结果，这就是你想要的数据。


> 1.4 流的操作过程

使用流一共需要三步：

>> a.准备一个数据源

>> b.执行中间操作 
中间操作可以有多个，它们可以串连起来形成流水线。

>> c.执行终端操作 
执行终端操作后本次流结束，你将获得一个执行结果。

PS:jdk版本不能定于1.8 